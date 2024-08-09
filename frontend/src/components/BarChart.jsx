import React from 'react';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

// Register Chart.js components (necessary since Chart.js v3)
ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const BarChart = (props) => {
    function getRandomColor() {
        const r = Math.floor(Math.random() * 255);
        const g = Math.floor(Math.random() * 255);
        const b = Math.floor(Math.random() * 255);
        return `rgba(${r}, ${g}, ${b}, 0.4)`; // 0.4 for some transparency
    }
    
    let charMap = new Map(Object.entries(props.charHistogram));
    const labelsArray = Array.from(charMap.keys());
    const valuesArray = Array.from(charMap.values());
    const colorsArray = valuesArray.map(() => getRandomColor());

    const data = {
        labels: labelsArray,
        datasets: [{
            data: valuesArray,
            backgroundColor: colorsArray,
            borderColor: colorsArray.map(color => color.replace('0.4', '1')),
            borderWidth: 1,
        }],
    };

    const options = {
        plugins: {
        title: {
            display: true,
            text: 'Character Frequency'
        },
        legend: {
            display: false,
            position: 'top',
        },
        },
        scales: {
        x: {
            beginAtZero: true,
        },
        y: {
            beginAtZero: true,
        },
        },
    };

    return <Bar data={data} options={options} width="30%" height="30px"/>;
};

export default BarChart;
