import logging
import re

import apache_beam as beam
from apache_beam.io import ReadFromText
from apache_beam.io import WriteToText
from apache_beam.options.pipeline_options import PipelineOptions
from apache_beam.options.pipeline_options import SetupOptions


class ComputeWordLengthFn(beam.DoFn):
    def process(self, element):
        return [len(element)]


"""
DoFn that takes one line of text and parses it into a  list of words,
returns the list of words
"""
class ParseLineOfWordsFn(beam.DoFn):
    def process(self, line):
        return re.findall(r'[A-Za-z\']+', line)


def parse_line_of_words(line):
    return re.findall(r'[A-Za-z\']+', line)


def main(argv=None, save_main_session=True):
    pipeline_options = PipelineOptions()
    pipeline_options.view_as(SetupOptions).save_main_session = save_main_session
    input_file = 'cat_poem.txt'
    with beam.Pipeline(options=pipeline_options) as p:
        # Read the text file[pattern] into a PCollection.
        lines = p | ReadFromText(input_file)
        # Count the occurrences of each word.
        words = (lines
                 | 'Split' >> (beam.FlatMap(
                        #ParseLineOfWordsFn())  # will NOT work - why??
                        lambda line: parse_line_of_words(line))
                        #lambda x: re.findall(r'[A-Za-z\']+', x)).with_output_types(str)
                    )
                )
        # print results to the console
        words | beam.Map(lambda event: print("words element: ", event))
        # Write the output using a "Write" transform that has side effects.
        #words | WriteToText("cat_poem_results.txt")

        print("Lengths of words: ")
        # example of using custom DoFn
        len_of_words = words | beam.ParDo(ComputeWordLengthFn())
        # example of using a simplified lambda function
        len_of_words_lambda = words | beam.Map(
            lambda word: len(word)
        )

        len_of_words | beam.Map(lambda event: print("from len_of_words: ", event))
        len_of_words_lambda | beam.Map(lambda event: print("from len_of_words_lambda: ", event))


def print_event(event):
    print("{}".format(event))


if __name__ == '__main__':
    logging.getLogger().setLevel(logging.INFO)
    main()
