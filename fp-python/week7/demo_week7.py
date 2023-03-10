import pandas as pd


def do_pandas_simple():
    my_numbers = [1,2,3]
    df = pd.DataFrame(my_numbers)
    print("df = \n{}".format(df))
    # transform numbers using my mapper function
    df_tr_apply = df.apply(my_map_fn)
    print("df_tr_apply = \n{}".format(df_tr_apply))
    # same - using transform()
    df_tr = df.transform(my_map_fn)
    print("df_tr = \n{}".format(df_tr))
    # transform using lambdas
    df_tr_lambdas = df.apply(lambda x: x*2+5)
    print("df_tr_lambdas = \n{}".format(df_tr_lambdas))


def my_map_fn(int_item):
    multiply_by = 2
    add_factor = 5
    try:
        result = int_item * multiply_by + add_factor
        return result
    except Exception as e:
        print("EXCEPTION in my_map_fn(): {}", format(str(e)))


def demo_basic_operations():
    animals = [
        ("cat", "Sparky", 5),
        ("dog", "Hero", 10),
        ("dog", "Pirate", 3),
        ("cat", "Lazy", 6),
        ("cat", "Baby", 0.5)
    ]
    df = pd.DataFrame(animals, columns=['Type', 'Name', 'Age'])
    print("df = \n{}".format(df))
    print("Shape: {}".format(df.shape))
    print("Size: {}".format(df.size))
    print("Values: {}".format(df.values))
    print("Head (1 row): {}".format(df.head(1)))
    print("Tail (1 row): {}".format(df.tail(1)))


def do_groupby_with_agg():
    animals = [
        ("cat", "Sparky", 5),
        ("dog", "Hero", 10),
        ("dog", "Pirate", 3),
        ("cat", "Lazy", 6),
        ("cat", "Baby", 0.5)
    ]
    df = pd.DataFrame(animals, columns=['Type', 'Name', 'Age'])
    print("df = \n{}".format(df))
    groups_by_type = df.groupby(['Type'])
    print("groups_by_type = {}\n".format(groups_by_type))
    groups_by_type.apply(print)
    print("groups: {}".format(groups_by_type.groups))
    groups_by_type_avg_age = groups_by_type.aggregate("mean")
    print("groups_by_type_avg_age = \n{}".format(groups_by_type_avg_age))
    # same as using "mean"
    groups_by_type_avg_age_np = groups_by_type.mean()
    print("groups_by_type_avg_age_np = \n{}".format(groups_by_type_avg_age_np))


if __name__ == "__main__":
    demo_basic_operations()
    do_pandas_simple()
    do_groupby_with_agg()
