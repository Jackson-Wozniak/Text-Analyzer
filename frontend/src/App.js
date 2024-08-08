import './styles/App.css';
import {readOutputNames, retrieveFileContents} from './utils/FileReader';
import { useState } from 'react';
import FileContents from './components/FileContents';

function App() {
  const [isOpenFile, setIsOpenFile] = useState(false);
  const [fileContents, setFileContents] = useState(null);

  function openFile(){
    setIsOpenFile(true);
    setFileContents(retrieveFileContents(""));
  }

  function closeFile(){
    setIsOpenFile(false);
    setFileContents(null);
  }

  if(isOpenFile){
    return <FileContents contents={fileContents} closeFile={closeFile}/>
  }

  return (
    <div className="App">
      <header className="App-header">
        <button onClick={() => openFile()}>Open</button>
      </header>
    </div>
  );
}

export default App;
