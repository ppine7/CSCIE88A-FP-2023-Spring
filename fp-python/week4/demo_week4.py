from functools import reduce
import random

from week4.Animal import Animal
from week4.Cat import Cat


def create_list_of_animals():
    my_animals = [Animal("Demon", "green", "black"),
                  Animal("Fluffy", "grey", "black"),
                  Animal("Snow", "green", "white"),
                  Animal("Sneaky", "blue", "orange")]
    return my_animals


def list_operations():
    my_list_animals = create_list_of_animals()
    print("Starting my_list_animals: {}".format(my_list_animals))
    # remove last animal
    length = len(my_list_animals)
    my_list_animals.pop(length - 1)
    print("After removal: my_list_animals: {}".format(my_list_animals))
    # get the first animal
    animal1 = my_list_animals[0]
    print("animal1 = {}".format(animal1))
    # modify it
    animal1.eye_color = "brown"
    print("updated animal1 = {}".format(animal1))
    # print the list
    print("updated my_list_animals: {}".format(my_list_animals))


def play_with_tuples():
    # in tuples - we can have different object types!
    rogue_cat = Cat("Rogue", "blue", "grey")
    my_animals_tuple = (Animal("Demon", "green", "black"),
                        Animal("Fluffy", "grey", "black"),
                        Animal("Snow", "green", "white"),
                        Animal("Sneaky", "blue", "orange"),
                        rogue_cat)
    print("Starting my_animals_tuple: {}".format(my_animals_tuple))
    # remove the sneaky cat ?
    # my_animals_tuple.pop(rogue_cat) ???
    # update the rogue cat
    rogue_cat.body_color = "invisible"
    print("after update: my_animals_tuple: {}".format(my_animals_tuple))
    filtered_list = list(filter(lambda item: item.eye_color == 'green', my_animals_tuple))
    print("filtered_tuple: {}".format(filtered_list))


# test filter() on lists
def do_filter_on_list():
    my_animals = create_list_of_animals()
    filtered_animals_iter = filter(lambda item: item.eye_color == 'green', my_animals)
    print("filtered_animals_iter: {}".format(filtered_animals_iter))
    filtered_animals = list(filtered_animals_iter)
    print("filtered_animals: {}".format(filtered_animals))


def do_map_on_list():
    my_numbers = [1,2,3]
    my_doubles = list(map(lambda x: x*2, my_numbers))
    print("my_doubles = {}".format(my_doubles))
    my_list_animals = create_list_of_animals()
    # cannot change objects in lambdas directly - have to use a separate function
    mapped_animals = list(map(update_item, my_list_animals))
    print("mapped_animals: {}".format(mapped_animals))


def update_item(cat):
    cat.name = "new_name"
    return cat


def do_reduce_on_list():
    string_list = ["cat1", "cat2", "cat3"]
    all_cats = reduce(lambda x, y: x + '_' + y, string_list)
    print("simple reduce: all_cats = {}".format(all_cats))
    my_list_animals = create_list_of_animals()
    # test reduce on list
    # cannot change objects in lambdas directly - have to use a separate function
    random_animal = reduce(reduce_randomize_items, my_list_animals)
    print("random_animal: {}".format(random_animal))


def reduce_randomize_items(item1, item2):
    new_animal = Animal("empty", "empty", "empty")
    # create a new animal by picking some attributes from the first one
    # and some from the second one
    # randomize name
    rand_bool = random.choice([True, False])
    if rand_bool:
        new_animal.name = item1.name
    else:
        new_animal.name = item2.name
    # randomize body color
    rand_bool = random.choice([True, False])
    if rand_bool:
        new_animal.body_color = item2.body_color
    else:
        new_animal.body_color = item1.body_color
    # randomize eye color
    rand_bool = random.choice([True, False])
    if rand_bool:
        new_animal.eye_color = item2.eye_color
    else:
        new_animal.eye_color = item1.eye_color
    return new_animal


def play_with_dictionaries():
    # create a dictionary where key == ssn, value == animal
    my_dict = {
        "ssn1": Animal("Demon", "green", "black"),
        "ssn2": Animal("Fluffy", "grey", "black"),
        "ssn3": Animal("Snow", "green", "white"),
        "ssn4": Animal("Sam", "yellow", "orange")
    }
    print("original my_dict: {}".format(my_dict))
    # add one more animal
    my_dict["ssn5"] = Animal("Sneaky", "blue", "orange")
    print("After add: original my_dict: {}".format(my_dict))
    my_names = list(map(lambda item: item[1].name, my_dict.items()))
    print("my_names = {}".format(my_names))
    # chaining map and filter operations
    my_filtered_names = list(filter(lambda item: item.startswith("S"), my_names))
    print("my_filtered_names = {}".format(my_filtered_names))

    # example of returning a new dictionary as a result of map()
    input_dict = {'A': 0, 'B': 1, 'C': 2}
    result_dict = dict(map(lambda x: (x[0], add_one_fn(x[1])), input_dict.items()))
    print("result_dict = ", result_dict)  # {'A': 1, 'B': 2, 'C': 3}


def add_one_fn(x):
    return x+1


if __name__ == "__main__":
    create_list_of_animals()
    list_operations()
    play_with_dictionaries()
    do_filter_on_list()
    do_map_on_list()
    do_reduce_on_list()
    play_with_tuples()
