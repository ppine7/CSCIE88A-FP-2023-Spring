from week2.Animal import Animal


class Dog(Animal):
    # overwrite class attribute
    species_name = "Canis lupus familiaris"

    # use parent's constructor
    def __init__(self, name, eye_color, body_color):
        super().__init__(name, eye_color, body_color)


