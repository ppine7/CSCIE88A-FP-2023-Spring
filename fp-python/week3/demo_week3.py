
def train_for_tricks_no_arg(do_trick_no_arg_fn):
    if do_trick_no_arg_fn():
        print("I'm doing the trick!")
        return True
    else:
        print("I'm NOT doing the trick!")
        return False


def train_for_tricks_one_arg(do_trick_one_arg_fn, trick_name):
    if do_trick_one_arg_fn(trick_name):
        print("I'm doing the trick: {}!".format(trick_name))
        return True
    else:
        print("I'm NOT doing the trick {}!".format(trick_name))
        return False
