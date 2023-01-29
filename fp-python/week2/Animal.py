class Animal:
    # class attribute:
    species_name = "General Animal"

    # instance attributes
    def __init__(self, name, eye_color, body_color):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color

    # an "interface"-like method
    def do_trick(self, trick_name):
        return True

    def take_medicine(self, with_treat):
        if with_treat:
            return True
        else:
            return False

    def who_am_i(self):
        return ("I am a  {}! My name is {}, I have {} eyes and {} body"
                .format(self.species_name, self.name, self.eye_color, self.body_color))
