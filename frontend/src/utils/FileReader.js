const IS_DEV_ENV = true;
const OUTPUT_MANAGER_URL = 'https://raw.githubusercontent.com/Jackson-Wozniak/Text-Analyzer/main/text_files/output_files.txt'

export function readOutputNames(){
    return fetch(OUTPUT_MANAGER_URL)
        .then(response => response.text())
        .then(data => {
            const wordsArray = data.split(/\s+/)
            console.log(wordsArray);
            return wordsArray;
        })
        .catch(error => {
            console.error('Error fetching file:', error);
        });
}

export function retrieveFileContents(URL){
    return "{}";
}
