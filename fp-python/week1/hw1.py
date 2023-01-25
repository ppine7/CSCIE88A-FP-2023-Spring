
input_filename = "../resources/celsius-data.txt"
output_filename = "../output/fahrenheit-data1.txt"

def convert_temps():
    # open input file and read all lines into a list
    # NOTE: we are assuming the input file is small here; if this is not true - read one line at a time instead
    input_file = open(input_filename, 'r')
    input_lines = input_file.readlines()

    # Open an output file
    output_file = open(output_filename, "w")
    # process lines from the input file and write the results out
    for line in input_lines:
        output_value = convert_c_to_f(line)
        if output_value:
            output_file.write(output_value + "\n")
    # close all resources
    input_file.close()
    output_file.close()
    print(output_filename + " is written!")


def convert_c_to_f(input_line):
    # validate the line - has to be a number; ignore any wrong formatted lines
    if not input_line or input_line.startswith("#"):
        return None
    # convert the string value into a float value and then into Fahrenheit
    try:
        input_value_as_float = float(input_line)
        f_value = input_value_as_float * 1.8 + 32.0
        return str(f_value)
    except Exception as e:
        print("error converting input line: {} from Celcius to Farhenheit: {}".format(input_line, e))
        return None


if __name__ == "__main__":
    convert_temps()
