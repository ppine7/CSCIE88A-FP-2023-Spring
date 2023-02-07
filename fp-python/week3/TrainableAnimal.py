class TrainableAnimal:

    # instance attributes
    def __init__(self, name, eye_color, body_color):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color

    # function with no arguments
    def do_trick_no_arg(self):
        return True

    # function with one argument
    def do_trick_one_arg(self, trick_name):
        print("executing do_trick_one_arg({}) function ...".format(trick_name))
        if trick_name == 'RUN':
            return True
        else:
            return False

    # example of assigning a function to a variable
    another_do_trick_one_arg = do_trick_one_arg

    def get_trick_function(self):
        print("Returning do_trick_one_arg() function ...")
        return self.do_trick_one_arg

