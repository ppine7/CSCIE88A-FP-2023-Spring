from week1.hw1 import convert_c_to_f


def test_convert_positive_int():
    input_line = "20"
    expected_value = "68.0"
    actual_result = convert_c_to_f(input_line)
    assert expected_value == actual_result


def test_convert_negative_int():
    input_line = "-20"
    expected_value = "-4.0"
    actual_result = convert_c_to_f(input_line)
    assert expected_value == actual_result


def test_convert_comment():
    input_line = "#-20"
    expected_value = None
    actual_result = convert_c_to_f(input_line)
    assert expected_value == actual_result


def test_convert_bad_format():
    input_line = "bad_value"
    expected_value = None
    actual_result = convert_c_to_f(input_line)
    assert expected_value == actual_result
