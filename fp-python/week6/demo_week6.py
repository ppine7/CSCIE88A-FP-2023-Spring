from functools import reduce
import multiprocessing as mp


def do_map_no_parallelization():
    my_numbers = [1,2,3]
    mapped_numbers = list(map(lambda x: x*2+5, my_numbers))
    print("mapped_numbers = {}".format(mapped_numbers))
    # cannot call my_map_fn_with_args() with parameters directly - can you think of a way??
    # Tip: use tuples


# Run apply() operations with multiple parameters
def do_apply_with_args():
    cpu_count = mp.cpu_count()
    print("Starting do_apply_with_args() with {} CPUs".format(cpu_count))
    pool = mp.Pool(mp.cpu_count())
    my_numbers = [1,2,3]
    multiply_by = 2
    add_factor = 5
    # mapped_numbers = [pool.apply(my_map_fn_with_args, args=(multiply_by, add_factor, item)) for item in my_numbers]
    # same as above - converting to list explicitly here
    mapped_numbers = list(pool.apply(my_map_fn_with_args, args=(multiply_by, add_factor, item)) for item in my_numbers)
    print("mapped_numbers = {}".format(mapped_numbers))
    pool.close()


def my_map_fn_with_args(multiply_by, add_factor, int_item):
    return int_item * multiply_by + add_factor


# Run map() operation in parallel
def do_map_parallel():
    cpu_count = mp.cpu_count()
    print("Starting do_map_parallel() with {} CPUs".format(cpu_count))
    pool = mp.Pool(cpu_count)
    my_numbers = range(24)
    chunk_size = cpu_count
    mapped_numbers = pool.map(my_map_fn_no_args, my_numbers, chunk_size)
    print("mapped_numbers = {}".format(mapped_numbers))
    pool.close()


# Run map operations via async mode no callback
def do_map_parallel_async():
    cpu_count = mp.cpu_count()
    print("Starting do_map_parallel_asynch() with {} CPUs".format(cpu_count))
    pool = mp.Pool(cpu_count)
    my_numbers = range(20)
    chunk_size = cpu_count
    # mapped_numbers_results is a list of pool.ApplyResult objects
    map_result = pool.map_async(
        my_map_fn_no_args, my_numbers, chunk_size)
    mapped_numbers = map_result.get(timeout=2.0)
    print("mapped_numbers = {}".format(mapped_numbers))
    pool.close()


# Run map operations via async mode with callback
def do_map_parallel_async_with_callback():
    cpu_count = mp.cpu_count()
    print("Starting do_map_parallel_asynch_with_callback() with {} CPUs".format(cpu_count))
    pool = mp.Pool(cpu_count)
    my_numbers = range(20)
    chunk_size = cpu_count
    # mapped_numbers_results is a list of pool.ApplyResult objects
    map_result = pool.map_async(
        my_map_fn_no_args, my_numbers, chunk_size, map_callback_fn)
    # what happens if you do NOT wait() ???
    map_result.wait(timeout=2.0)
    print("do_map_parallel_async_with_callback() is done")
    pool.close()


def do_map_parallel_with_reduce():
    cpu_count = mp.cpu_count()
    print("Starting do_map_parallel_with_reduce() with {} CPUs".format(cpu_count))
    pool = mp.Pool(cpu_count)
    my_numbers = range(24)
    chunk_size = cpu_count
    mapped_numbers = pool.map(my_map_fn_no_args, my_numbers, chunk_size)
    print("mapped_numbers = {}".format(mapped_numbers))
    pool.close()
    sum_of_all = reduce(lambda x, y: x+y, mapped_numbers)
    print("sum_of_all = {}".format(sum_of_all))


def map_callback_fn(final_result):
    print("final_result from map_callback_fn() = {}".format(final_result))


def my_map_fn_no_args(int_item):
    multiply_by = 2
    add_factor = 5
    try:
        result = int_item * multiply_by + add_factor
        return result
    except Exception as e:
        print("EXCEPTION in my_map_fn_no_args(): {}", format(str(e)))


if __name__ == "__main__":
    #do_apply_with_args()
    #do_map_no_parallelization()
    #do_map_parallel()
    #do_map_parallel_with_reduce()
    #do_map_parallel_async()
    do_map_parallel_async_with_callback()