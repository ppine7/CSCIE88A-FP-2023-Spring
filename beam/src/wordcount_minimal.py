#
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

"""A minimalist word-counting workflow that counts words in Shakespeare.

This is the first in a series of successively more detailed 'word count'
examples.

Next, see the wordcount pipeline, then the wordcount_debugging pipeline, for
more detailed examples that introduce additional concepts.

Concepts:

1. Reading data from text files
2. Specifying 'inline' transforms
3. Counting a PCollection
4. Writing data to Cloud Storage as text files

To execute this pipeline locally, first edit the code to specify the output
location. Output location could be a local file path or an output prefix
on GCS. (Only update the output location marked with the first CHANGE comment.)

To execute this pipeline remotely, first edit the code to set your project ID,
runner type, the staging location, the temp location, and the output location.
The specified GCS bucket(s) must already exist. (Update all the places marked
with a CHANGE comment.)

Then, run the pipeline as described in the README. It will be deployed and run
using the Google Cloud Dataflow Service. No args are required to run the
pipeline. You can see the results in your output bucket in the GCS browser.
"""

# pytype: skip-file

import argparse
import logging
import re

import apache_beam as beam
from apache_beam.io import ReadFromText
from apache_beam.io import WriteToText
from apache_beam.options.pipeline_options import PipelineOptions
from apache_beam.options.pipeline_options import SetupOptions


def main(argv=None, save_main_session=True):
    """Main entry point; defines and runs the wordcount pipeline."""

    parser = argparse.ArgumentParser()
    parser.add_argument(
        '--input',
        dest='input',
        default='gs://dataflow-samples/shakespeare/kinglear.txt',
        help='Input file to process.')
    parser.add_argument(
        '--output',
        dest='output',
        # CHANGE 1/6: The Google Cloud Storage path is required
        # for outputting the results.
        default='gs://YOUR_OUTPUT_BUCKET/AND_OUTPUT_PREFIX',
        help='Output file to write results to.')

    known_args, pipeline_args = parser.parse_known_args(argv)
    pipeline_options = PipelineOptions(pipeline_args)

    pipeline_options.view_as(SetupOptions).save_main_session = save_main_session

    input_file = 'gs://dataflow-samples/shakespeare/kinglear.txt'
    #input_file = 'cat_poem.txt'
    with beam.Pipeline(options=pipeline_options) as p:
        # Read the text file[pattern] into a PCollection.
        lines = p | ReadFromText(input_file)
        # Count the occurrences of each word.
        counts = (lines
                  | 'Split' >> (beam.FlatMap(
                    lambda x: re.findall(r'[A-Za-z\']+', x)).with_output_types(str))
                  | 'PairWithOne' >> beam.Map(lambda x: (x, 1))
                  | 'GroupAndSum' >> beam.CombinePerKey(sum))

        output = counts | 'Format' >> beam.Map(format_result)
        # print results to the console
        output | beam.Map(lambda event: print(event))
        # Write the output using a "Write" transform that has side effects.
        output | WriteToText("wc_results.txt")


# Format the counts into a PCollection of strings.
def format_result(word_count):
    (word, count) = word_count
    return '%s: %s' % (word, count)


def print_event(event):
    print("{}".format(event))


if __name__ == '__main__':
    logging.getLogger().setLevel(logging.INFO)
    main()
