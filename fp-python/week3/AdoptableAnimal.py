class AdoptableAnimal:

    # instance attributes
    def __init__(self, name, eye_color, body_color):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color

    # no arguments, always returns true
    def ready_for_adoption_no_arg(self):
        print("ready_for_adoption_no_arg() is called - returning True always")
        return True

    # method with one argument
    def ready_for_adoption_one_arg(self, health_check_done):
        print("ready_for_adoption_one_arg(...) is called - returning the argument value: {}".format(health_check_done))
        if health_check_done:
            return True
        else:
            return False

