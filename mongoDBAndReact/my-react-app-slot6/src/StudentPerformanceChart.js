import React, { useEffect, useState } from 'react';
import { Bar } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend } from 'chart.js';

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

const StudentPerformanceChart = () => {
    const [chartData, setChartData] = useState({
        labels: [], // Subjects
        datasets: [], // Datasets for each metric (average, highest, lowest) per year
    });

    useEffect(() => {
        // Replace this URL with your API endpoint
        fetch('http://localhost:8080/studentexambyyear')
            .then((response) => response.json())
            .then((data) => {
                // Process data
                const years = [...new Set(data.map(item => item.year))].sort(); // Unique years
                const subjects = [...new Set(data.map(item => item.subject))]; // Unique subjects

                // Initialize datasets
                const averageScoreData = {
                    label: 'Average Score',
                    data: [],
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1,
                    stack: 'stack0',
                };

                const highestScoreData = {
                    label: 'Highest Score',
                    data: [],
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1,
                    stack: 'stack1',
                };

                const lowestScoreData = {
                    label: 'Lowest Score',
                    data: [],
                    backgroundColor: 'rgba(255, 159, 64, 0.2)',
                    borderColor: 'rgba(255, 159, 64, 1)',
                    borderWidth: 1,
                    stack: 'stack2',
                };

                // Map data to datasets
                subjects.forEach(subject => {
                    years.forEach(year => {
                        const entry = data.find(d => d.year === year && d.subject === subject);

                        averageScoreData.data.push(entry ? entry.averageScore : 0);
                        highestScoreData.data.push(entry ? entry.highestScore : 0);
                        lowestScoreData.data.push(entry ? entry.lowestScore : 0);
                    });
                });

                setChartData({
                    labels: years,
                    datasets: [averageScoreData, highestScoreData, lowestScoreData],
                });
            })
            .catch((error) => console.error('Error fetching data:', error));
    }, []);

    return (
        <div>
            <h2>Student Performance by Subject and Year</h2>
            <Bar
                data={chartData}
                options={{
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'top',
                        },
                        title: {
                            display: true,
                            text: 'Scores by Year and Subject',
                        },
                    },
                    scales: {
                        x: {
                            stacked: true,
                            title: {
                                display: true,
                                text: 'Year',
                            },
                        },
                        y: {
                            stacked: true,
                            beginAtZero: true,
                            title: {
                                display: true,
                                text: 'Score',
                            },
                        },
                    },
                }}
            />
        </div>
    );
};

export default StudentPerformanceChart;
