class Animal:

    # instance attributes
    def __init__(self, name, eye_color, body_color):
        self.name = name
        self.eye_color = eye_color
        self.body_color = body_color

    # implement this method if you want the object to be nicely printed in collections
    def __str__(self):
        return "Animal:{}-{}-{}\n".format(self.name, self.eye_color, self.body_color)

    # implement this method if you want the object to be nicely printed in collections
    def __repr__(self):
        return "Animal:{}-{}-{}\n".format(self.name, self.eye_color, self.body_color)