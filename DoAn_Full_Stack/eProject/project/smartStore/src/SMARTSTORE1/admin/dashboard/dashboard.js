import React from "react";
import './dashboard.css';
import { BarChart, Bar, Rectangle, LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, Legend} from 'recharts';
import MenuAdmin from "../menuAdmin/menuAdmin";

function Dashboard() {
    const data = [
        { name: 'Page A', uv: 4000, pv: 2400, amt: 2400 },
        { name: 'Page B', uv: 3000, pv: 1398, amt: 2210 },
        { name: 'Page C', uv: 2000, pv: 9800, amt: 2290 },
        { name: 'Page D', uv: 2780, pv: 3908, amt: 2000 },
        { name: 'Page E', uv: 1890, pv: 4800, amt: 2181 },
        { name: 'Page F', uv: 2390, pv: 3800, amt: 2500 },
        { name: 'Page G', uv: 3490, pv: 4300, amt: 2100 },
    ];

    return (
        <div className="menuadmin"><MenuAdmin />
        <div className="body-dashboard">
           
            <div className="title-dahos">
                <h1>Statistics Analysis</h1>
            </div>
            <div className="table-ts">
                <table className="table-ts2">
                    <tr className="btn-ts">
                        <td className="btn-tpsp">PRODUCT</td>
                        <td className="btn-tpsp2">CATEGORY</td>
                        <td className="btn-tpsp3">CUSTOMERS</td>
                        <td className="btn-tpsp4">ALERTS</td>
                    </tr>
                    <tr className="btn-ts">
                        <td className="btn-tpsp">50</td>
                        <td className="btn-tpsp2">60</td>
                        <td className="btn-tpsp3">70</td>
                        <td className="btn-tpsp4">80</td>
                    </tr>
                </table>
            </div>
            <div className="chart-container">
                <div className="line-chart">
                    <LineChart
                        width={600}
                        height={500}
                        data={data}
                        margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
                    >
                        <CartesianGrid strokeDasharray="3 3" />
                        <XAxis dataKey="name" />
                        <YAxis />
                        <Tooltip />
                        <Legend />
                        <Line type="monotone" dataKey="pv" stroke="#8884d8" activeDot={{ r: 8 }} />
                        <Line type="monotone" dataKey="uv" stroke="#82ca9d" />
                    </LineChart>
                </div>
                <div className="bar-chart">
                    <BarChart
                            width={600}
                            height={500}
                            data={data}
                            margin={{ top: 5, right: 30, left: 20, bottom: 5 }}
                        >
                            <CartesianGrid strokeDasharray="3 3" />
                            <XAxis dataKey="name" />
                            <YAxis />
                            <Tooltip />
                            <Legend />
                            <Bar dataKey="pv" fill="#8884d8" activeBar={<Rectangle fill="pink" stroke="blue" />} />
                            <Bar dataKey="uv" fill="#82ca9d" activeBar={<Rectangle fill="gold" stroke="purple" />} />
                        </BarChart>
                </div>
            </div>
        </div>
        </div>
    )
}
export default Dashboard;
