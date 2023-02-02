from week2.Animal import Animal
from week2.Cat2 import Cat2
from week2.Dog import Dog


def test_take_medicine():
    just_animal = Animal("Mystery", "grey", "white")
    demon_cat = Cat2("Demon", "green", "black")
    buddy_dog = Dog("Buddy", "blue", "brown")
    # verify that if take_medicine() is called without a treat -
    # nobody will take it
    with_treat = False
    assert not just_animal.take_medicine(with_treat)
    assert not buddy_dog.take_medicine(with_treat)
    assert not demon_cat.take_medicine(with_treat)
    # verify that if take_medicine() is called with a treat -
    # Dog and Animal will take it, but the Cat - will not
    with_treat = True
    assert just_animal.take_medicine(with_treat)
    assert buddy_dog.take_medicine(with_treat)
    assert not demon_cat.take_medicine(with_treat)
