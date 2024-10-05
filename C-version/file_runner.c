#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include "text_file.h"

void generate_linked_list(char** filenames){
    FILE* input_manager = fopen("input/input_manager.txt", "r");
    char filename[100];

    int count = 0;
    while(fgets(filename, 100, input_manager) != NULL){
        filenames[count] = malloc(strlen(filename) + 1);
        strcpy(filenames[count], filename);
        if(access(filename, F_OK) == 0){
            printf("VALID: %s\n", filename);
        }
        count++;
    }
    fclose(input_manager);
}

int main(int argc, char* argv[]){
    char* filenames[2];
    generate_linked_list(filenames);
    return 0;
}