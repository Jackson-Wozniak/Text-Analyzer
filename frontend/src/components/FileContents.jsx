import React from 'react';
import BarChart from './BarChart';

function FileContents(props){
    let wordMap = new Map(Object.entries(props.content.wordHistogram));

  return (
    <div>
        <div>
            <button onClick={() => props.closeFile()}>CLOSE</button>
            <h2>Lines : {props.content.lineCount}</h2>
            <h2>Words: {props.content.wordCount}</h2>
            <div style={{display: 'flex', flexDirection : 'row'}}>
            <div style={{width: '30%'}}>
                <BarChart charHistogram={props.content.charHistogram}/>
            </div>
            <div style={{width: '30%'}}>
                <table style={{ width: '100%', borderCollapse: 'collapse' }}>
                    <thead>
                        <tr>
                            <th style={{ border: '1px solid black', padding: '8px' }}></th>
                            <th style={{ border: '1px solid black', padding: '8px' }}>Word</th>
                            <th style={{ border: '1px solid black', padding: '8px' }}>Frequency</th>
                        </tr>
                    </thead>
                    <tbody>
                        {Array.from(wordMap.entries()).map(([key, value], index) => (
                            <tr key={index}>
                            <td style={{ border: '1px solid black', padding: '8px' }}>{index + 1}</td>
                            <td style={{ border: '1px solid black', padding: '8px' }}>{key}</td>
                            <td style={{ border: '1px solid black', padding: '8px' }}>{value}</td>
                        </tr>
                        ))}
                    </tbody>
                </table>
            </div>
            </div>
        </div>
    </div>
  )
};

export default FileContents;