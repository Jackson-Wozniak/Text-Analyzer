import './styles/App.css';
import {readOutputNames, retrieveFileContents, FileData} from './utils/FileReader';
import { useState, useEffect } from 'react';
import FileContents from './components/FileContents';

function App() {

  useEffect(() => {
    const fetchData = async () => {
      const files = await readOutputNames();
      setFileNames(files);
    };

    fetchData();
  }, []);

  const [fileNames, setFileNames] = useState([]);
  const [isOpenFile, setIsOpenFile] = useState(false);
  const [fileContents, setFileContents] = useState(null);

  async function openFile(){
    let data = await retrieveFileContents("");
    setFileContents(data);
    console.log(fileContents);
    setIsOpenFile(true);
  }

  function closeFile(){
    setIsOpenFile(false);
    setFileContents(null);
  }

  if(isOpenFile){
    return <FileContents content={fileContents} closeFile={closeFile}/>
  }

  return (
    <div className="App">
      <header className="App-header">
        {fileNames.map((name, index) => (
          <button key={index} onClick={() => openFile(name)}>{name}</button>
        ))}
      </header>
    </div>
  );
}

export default App;
