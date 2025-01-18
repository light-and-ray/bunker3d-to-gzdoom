import json, os

def read_2d_list_from_json(filename):
    try:
        with open(filename, 'r') as file:
            data = json.load(file)
            # Convert all elements to integers
            return [[int(num) for num in row] for row in data]
    except FileNotFoundError:
        print(f"File {filename}.json not found")
        return None
    except json.JSONDecodeError:
        print(f"Invalid JSON in file {filename}.json")
        return None
    except Exception as e:
        print(f"An error occurred: {e}")
        return None


def readArray(arrayName: str):
    filename = f'tmp/{arrayName}.json'
    data = read_2d_list_from_json(filename)
    return data


def loadMap(mapIndex):
    returnCode = os.system(f'./runJava.sh {mapIndex}')
    if (returnCode != 0):
        raise Exception(f"java returned {returnCode}")
    return readArray('cW')
