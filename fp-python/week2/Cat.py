# totally outside method - what is it ??
def say_something_outside(message):
    what_i_say = "I am outside of the class; message={}".format(message)
    return what_i_say


class Cat:
    # class attribute
    species_name = "Felis catus"

    # instance attributes
    def __init__(self, name, eye_color, body_color):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color

    # instance method
    def say_something(self, message):
        what_i_say = "I don't care what you asked me to say - " \
                     "I say MEOW only: instance method"
        return what_i_say

    # instance method
    def who_am_i_instance(self):
        return ("I am a Cat, of species {}! I am an instance method - "
                "and my name is {}, I have {} eyes and {} body"
                .format(Cat.species_name, self.name, self.eye_color, self.body_color))

    # what is the parameter passed in to this method??
    @classmethod
    def who_am_i_class(cls):
        return ("I am a Cat, of species {}! I am a class method - cannot access any instance state "
                "but can access class variables: cls: {}"
                .format(Cat.species_name, cls.species_name))

    @staticmethod
    def who_am_i_static():
        return ("I am a Cat, of species {}! I am a static method - "
                "cannot access any instance state"
                .format(Cat.species_name))

    @staticmethod
    def who_am_i_static_bad(self):
        return ("I am a Cat, of species {}! I am a static method - but will try to access instance state: {}"
                .format(Cat.species_name, self.name))
