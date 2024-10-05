#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <dirent.h>
#include "text_file.h"

typedef struct FileNode{
    FILE* file;
    char* filename;
    struct FileNode* next;
} FileNode;

FileNode* new_file_node(char* filename, FILE* file){
    FileNode* file_node = (FileNode*)malloc(sizeof(FileNode));
    file_node->file = file;
    file_node->filename = (char*)malloc(strlen(filename) + 1);
    strcpy(file_node->filename, filename);
    file_node->next = NULL;

    return file_node;
}

void free_file_nodes(FileNode* head){
    while(head != NULL){
        FileNode* temp = head;
        fclose(temp->file);
        free(temp->filename);
        free(temp);

        head = head->next;
    }
}

FileNode* read_files_from_input(){
    FileNode* head = NULL;
    int file_count = 0;

    struct dirent* directory_entry;
    DIR* directory = opendir("./input");

    if(directory == NULL){
        printf("No input files!\n");
        exit(0);
    }

    while((directory_entry = readdir(directory)) != NULL){
        if(directory_entry->d_type == DT_REG){
            FILE* file = fopen(directory_entry->d_name, "r");
            FileNode* new_node = new_file_node(directory_entry->d_name, file);
            if(head == NULL){
                head = new_node;
            }else{
                new_node->next = head;
                head = new_node;
            }
            file_count++;
        }
    }

    printf("File Count: %d\n", file_count);
    return head;
}

int main(int argc, char* argv[]){
    FileNode* head = read_files_from_input();
    free_file_nodes(head);
    return 0;
}