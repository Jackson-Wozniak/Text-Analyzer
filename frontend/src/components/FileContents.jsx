import React from 'react';

function FileContents(props){
  return (
    <div>
        <button onClick={() => props.closeFile()}>CLOSE</button>
        <h3>{props.contents}</h3>
    </div>
  )
};

export default FileContents;