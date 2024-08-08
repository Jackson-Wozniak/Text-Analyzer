import './styles/App.css';
import {readOutputNames} from './utils/FileReader'

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <button onClick={() => readOutputNames()}></button>
      </header>
    </div>
  );
}

export default App;
