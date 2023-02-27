class Cat:
    # class attribute
    species_name = "Felis catus"

    # instance attributes
    def __init__(self, name, eye_color, body_color, age, health_check_completed):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color
        self.age = age
        self.health_check_completed = health_check_completed

    # implement this method if you want the object to be nicely printed in collections
    def __str__(self):
        return "Cat:{}-{}-{}-{}-{}".format(self.name, self.eye_color, self.body_color,
                                           self.age, self.health_check_completed)

    # implement this method if you want the object to be nicely printed in collections
    def __repr__(self):
        return "Cat:{}-{}-{}-{}-{}".format(self.name, self.eye_color, self.body_color,
                                           self.age, self.health_check_completed)
