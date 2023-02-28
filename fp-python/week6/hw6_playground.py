from functools import reduce
import random
import multiprocessing as mp

from week6.Cat import Cat


def create_list_of_cats(num_of_cats):
    my_animals = []
    for i in range(num_of_cats):
        name = "rCat" + str(i)
        my_animals.append(get_random_cat(name))
    return my_animals


def get_random_cat(name):
    random_cat = Cat(name,
                     random.choice(["green", "blue", "yellow"]),
                     random.choice(["black", "orange", "white"]),
                     random.randrange(20),
                     random.choice([True, False]))
    return random_cat


# TODO implement this as a parallel map() + reduce() pipeline
def get_average_age(list_of_cats):
    pass


# TODO implement this using Pool.map() parallelized execution
def reset_health_check_map_parallel(list_of_cats):
    pass


# TODO implement this using the Pool.map_async() with no callback
def reset_health_check_map_parallel_async(list_of_cats):
    pass


# TODO implement this using the Pool.map_async() with two callback functions:
# ## callback fn for results
# ## callback function to handle errors
def reset_health_check_map_parallel_async_with_callback(list_of_cats):
    pass
