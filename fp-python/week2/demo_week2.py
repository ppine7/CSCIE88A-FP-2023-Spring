from week2.Animal import Animal
from week2.Cat import Cat, say_something_outside
from week2.Cat2 import Cat2
from week2.Dog import Dog


def create_cats():
    # DOES NOT WORK!!! why??
    # empty_cat = Cat()
    #print("empty_cat.who_am_i() says: {}".format(empty_cat.who_am_I()))
    demon = Cat("Demon", "green", "black")


def call_cat_methods():
    demon = Cat("Demon", "green", "black")
    # call instance method defined inside of the class:
    response = demon.who_am_i_instance()
    print("demon.who_am_i_instance() says: {}".format(response))

    # call class method:
    response = demon.who_am_i_class()
    print("demon.who_am_i_class() says: {}".format(response))

    # call static method on instance:
    response = demon.who_am_i_static()
    print("demon.who_am_i_static() on instance says: {}".format(response))

    # call static method on class:
    response = Cat.who_am_i_static()
    print("Cat.who_am_i_static() on class says: {}".format(response))

    # call "bad" static method - what will happen ???
    # demon.who_am_i_static_bad()

    # call method defined outside of the class -
    # what's the difference with other static methods?
    say_something_outside("something!")


def create_cats_and_dogs():
    just_animal = Animal("Mystery", "grey", "white")
    demon_cat = Cat2("Demon", "green", "black")
    buddy_dog = Dog("Buddy", "blue", "brown")
    just_animal_whoami = just_animal.who_am_i()
    demon_cat_whoami = demon_cat.who_am_i()
    buddy_dog_whoami = buddy_dog.who_am_i()
    print("\n just_animal_whoami={}, \n demon_cat_whoami={}, \n buddy_dog_whoami={}".
          format(just_animal_whoami, demon_cat_whoami, buddy_dog_whoami))


if __name__ == "__main__":
    #create_cats()
    call_cat_methods()
    #create_cats_and_dogs()
