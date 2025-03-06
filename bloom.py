from pybloom_live import BloomFilter

def find_names(filename):
    try:
        with open(filename, 'r') as file:
            return [line.strip() for line in file]
    except FileNotFoundError:
        print("File not found. Please check the filename.")
        return []

def main():
    
    bloom = BloomFilter(capacity=100, error_rate=0.1)
    names = find_names('lists.txt')
    for name in names:
        bloom.add(name)
    while True:
    
        name = input("Enter the First and Last name (or END END to quit): ")
        if name == "END END":
            break
        if name in bloom:
            print(f"{name} is PROBABLY a Customer (with a probability of {1 - bloom.error_rate})")
        else:
            print(f"{name} is NOT a Customer")

if __name__ == "__main__":
    main()
