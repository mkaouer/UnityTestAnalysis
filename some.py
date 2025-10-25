import os

def list_first_level_directories(path, output_file):
    try:
        with open(output_file, 'w') as file:
            # List only the first-level directories
            for entry in os.listdir(path):
                full_path = os.path.join(path, entry)
                if os.path.isdir(full_path):  # Check if it's a directory
                    file.write(full_path + '\n')
        print(f"First-level directory names have been written to {output_file}.")
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    # Specify the directory to search and the output file name
    directory_to_search = input("Enter the directory path to search: ")
    output_file_name = '/media/umd-user/b07094e6-167c-4bb3-993e-58328ec3000f/Test-SMELL-PROJECT/UnityTestAnalysis/second_level_directories.txt'  # You can change this to your preferred filename

    list_first_level_directories(directory_to_search, output_file_name)
