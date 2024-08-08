const IS_DEV_ENV = true;
const OUTPUT_MANAGER_FILE = 'outputs.txt'

export function readOutputNames(){
    const reader = new FileReader();

    reader.onload = (event) => {
        const file = event.target.result;
        console.log(file);
    };

    reader.onerror = (event) => {
        alert(event.target.error.name);
    };
    
    reader.readAsText(new File([""], OUTPUT_MANAGER_FILE));
}