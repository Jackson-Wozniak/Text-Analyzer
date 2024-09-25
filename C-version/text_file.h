#define INPUT_MANAGER_PATH "../input_files/input_files.txt"
#define INPUT_DIRECTORY "../input_files/files/"
#define OUTPUT_MANAGER_PATH "output/output_names.txt"
#define OUTPUT_DIRECTORY "output/"

typedef struct CHAR_MAP_ENTRY{
    char* key;
    int value;
} CHAR_MAP_ENTRY;

typedef struct CHAR_MAP{
    int size;
    struct CHAR_MAP_ENTRY* entries;
} CHAR_MAP;

typedef struct TEXT_FILE{
    int line_count;
    int word_count;
    struct CHAR_MAP* char_histogram;
} TEXT_FILE;