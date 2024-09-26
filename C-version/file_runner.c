#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "text_file.h"

typedef struct FileNode{
    FILE* file;
    char* fileName;
    struct FileNode* next;
} FileNode;

FileNode* create_file_node(FILE *file, char* fileName) {
    FileNode *newNode = (FileNode*) malloc(sizeof(FileNode));
    if (newNode == NULL) {
        printf("Memory allocation error.\n");
        return NULL;
    }
    newNode->file = file;
    newNode->fileName = (char*)malloc(sizeof(char) * strlen(fileName));
    strcpy(newNode->fileName, fileName);
    newNode->next = NULL;
    return newNode;
}

void append_file(FileNode **head, FILE *file, char* fileName) {
    FileNode *newNode = create_file_node(file, fileName);
    if (*head == NULL) {
        *head = newNode;
    } else {
        FileNode *temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

FileNode* parse_files(){
    FILE* input_manager = fopen(INPUT_MANAGER_PATH, "r");

    FileNode* file_list = NULL;
    char fileName[100];
    while(fgets(fileName, 100, input_manager) != NULL){
        if(strcmp(" ", fileName) == 0) continue;
        fileName[strcspn(fileName, "\n")] = 0;
        FILE* temp = fopen(fileName, "r");
        append_file(&file_list, temp, fileName);
    }
    fclose(input_manager);
    return file_list;
}

void close_files(FileNode *head) {
    FileNode *temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        fclose(temp->file);
        free(temp);
    }
}

int main(int argc, char* argv[]){
    FileNode* head = parse_files();
    while(head != NULL){
        printf("%s\n", head->fileName);
        head = head->next;
    }
    return 0;
}