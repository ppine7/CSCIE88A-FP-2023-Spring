"""
main.py contains the main processing logic
"""
import json
import os
import base64
import logging

from google.cloud import bigquery

project = os.getenv("PROJECT")
logger = logging.getLogger(__name__)

"""
Cloud Function to load events into BQ
"""


def process_event(event, context):
    # pylint: disable=unused-argument
    decoded_event = json.loads(base64.b64decode(event['data']).decode('utf-8'))
    logger.info('Processing event: {}'.format(json.dumps(decoded_event)))
    bq_client = bigquery.Client()
    table = "my_bq_table"
    logger.info('about to load data into table: {}, decoded_event={}'.format(table, json.dumps(decoded_event)))
    #errors = bq_client.insert_rows_json(table, decoded_event)
    #if errors:
    #    logger.error('\nFailed to insert data into BigQuery: error: {}', json.dumps(errors))
    logger.info(" Finished processing event OK: {}".format(decoded_event))
    return decoded_event