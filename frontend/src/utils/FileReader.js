const IS_DEV_ENV = true;
const OUTPUT_MANAGER_URL = 'https://raw.githubusercontent.com/Jackson-Wozniak/Text-Analyzer/main/text_files/output_files.txt'

export async function readOutputNames(){
    const response = await fetch(OUTPUT_MANAGER_URL);
    const data = await response.text();
    const wordsArray = data.split(/\s+/);
    return wordsArray;
}

export function retrieveFileContents(URL){
    return "{}";
}
