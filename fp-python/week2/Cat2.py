from week2.Animal import Animal


class Cat2(Animal):
    # overwrite class attribute
    species_name = "Felis catus"

    # use parent's constructor
    def __init__(self, name, eye_color, body_color):
        super().__init__(name, eye_color, body_color)

    # overwrite parent's method
    def do_trick(self, trick_name):
        print("cats do not do tricks!")
        return False

    # overwrite parent's method
    def take_medicine(self, with_treat):
        print("You can't trick me - no medicine for me")
        return False


