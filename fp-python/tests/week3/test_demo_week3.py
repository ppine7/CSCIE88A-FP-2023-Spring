from week3.TrainableAnimal import TrainableAnimal
from week3.demo_week3 import train_for_tricks_no_arg, train_for_tricks_one_arg


def test_call_trainable_animal():
    myCat = TrainableAnimal("Demon", "green", "black")
    # call one arg method
    trick_name = "RUN"
    result1 = myCat.do_trick_one_arg(trick_name)
    # call a variable pointing to this same function:
    result2 = myCat.another_do_trick_one_arg(trick_name)
    assert result1 == result2


# use anonymous lambda with no args as a function parameter
def test_train_for_tricks_no_arg():
    result = train_for_tricks_no_arg(lambda: True)
    print("result = {}".format(result))
    assert result

    result = train_for_tricks_no_arg(lambda: False)
    print("result = {}".format(result))
    assert not result


# use named lambda with no args as a function parameter
def test_train_for_tricks_no_arg_named():
    my_do_trick_one_arg_fn = lambda: True
    result = train_for_tricks_no_arg(my_do_trick_one_arg_fn)
    print("result = {}".format(result))
    assert result
    # test when function returns False
    my_do_trick_one_arg_fn = lambda: False
    result = train_for_tricks_no_arg(my_do_trick_one_arg_fn)
    print("result = {}".format(result))
    assert not result


# use anonymous lambda with one argument as a function parameter
def test_train_for_tricks_one_arg():
    trick_name = 'RUN'
    # implementation of the do_trick_one_arg_fn with very simple logic
    result = train_for_tricks_one_arg(lambda trick_name_param: True, trick_name)
    print("result = {}".format(result))
    assert result

    # implementation of the do_trick_one_arg_fn with LESS simple logic
    trick_name = 'jump'
    result = train_for_tricks_one_arg(
        lambda trick_name_param: True if trick_name_param == 'jump' else False, trick_name)
    print("result = {}".format(result))
    assert result


# use named lambda with one argument as a function parameter
def test_train_for_tricks_one_arg_named():
    trick_name = 'RUN'
    # implementation of the do_trick_one_arg_fn with very simple logic
    my_do_trick_one_arg_fn = lambda trick_name_param: True
    result = train_for_tricks_one_arg(my_do_trick_one_arg_fn, trick_name)
    print("result = {}".format(result))
    assert result

    # implementation of the do_trick_one_arg_fn with LESS simple logic
    my_do_trick_one_arg_fn = lambda trick_name_param: True if trick_name_param == 'jump' else False
    result = train_for_tricks_one_arg(my_do_trick_one_arg_fn, trick_name)
    print("result = {}".format(result))
    assert not result


def test_train_for_tricks_one_arg_method_ref():
    trick_name = 'RUN'
    myCat = TrainableAnimal("Demon", "green", "black")
    # pass a method implemented in the TrainedAnimal as parameter
    result = train_for_tricks_one_arg(myCat.do_trick_one_arg, trick_name)
    print("result = {}".format(result))
    # verify the result is TRUE - since the trick_name = RUN
    assert result

    trick_name = 'jump'
    result = train_for_tricks_one_arg(myCat.do_trick_one_arg, trick_name)
    print("result = {}".format(result))
    # verify the result is FALSE - since the trick_name is NOT RUN
    assert not result


def test_function_as_return_value():
    trick_name = 'RUN'
    myCat = TrainableAnimal("Demon", "green", "black")
    # get the trick function from the TrainedAnimal
    returned_trick_fn = myCat.get_trick_function()
    # call the returned function
    result = returned_trick_fn(trick_name)
    print("result from the returned_trick_fn is: {}".format(result))

