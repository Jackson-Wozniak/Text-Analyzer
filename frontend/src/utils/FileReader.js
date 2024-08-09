const IS_DEV_ENV = true;
const OUTPUT_MANAGER_URL = 'https://raw.githubusercontent.com/Jackson-Wozniak/Text-Analyzer/main/text_files/output_files.txt'
const OUTPUT_ROOT = 'https://raw.githubusercontent.com/Jackson-Wozniak/Text-Analyzer/main/text_files/output/';

export async function readOutputNames(){
    const response = await fetch(OUTPUT_MANAGER_URL);
    const data = await response.text();
    const wordsArray = data.split(/\s+/);
    return wordsArray;
}

export async function retrieveFileContents(fileName){
    const response = await fetch('https://raw.githubusercontent.com/Jackson-Wozniak/Text-Analyzer/main/text_files/output/input1.txt');
    const json = await response.json();
    console.log(json);
    let data = new FileData(json);
    console.log(data);
    return new FileData(json);
}

export function FileData(json) {
    this.wordCount = json.wordCount;
    this.lineCount = json.lineCount;
    this.charHistogram = json.charHistogram;
    this.wordHistogram = json.wordHistogram;
}
