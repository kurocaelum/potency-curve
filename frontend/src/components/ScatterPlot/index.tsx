import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import { useEffect, useState } from 'react'
import api from '../../services/api'
import { ChartData, Pair } from '../../types/curve'

type PairJson = {
   first: number,
   second: number
 }

const ScatterPlot = () => {
   // TODO receber id via props
   const [id, setId] = useState(1)
   const [chartData, setChartData] = useState<ChartData>({ data: [] })

   useEffect(() => {
      api.get(`/curve/${id}`).then(response => {
         const data = response.data as PairJson[]
         
         const list: Pair[] = []
         data.forEach(x => list.push([x.first, x.second]))
         
         setChartData({ data: list })
      })
   }, [id])
   
   const options = {
      chart: {
         type: 'scatter',
         zoomType: 'xy',
      },
      title: {
         text: 'Curva de Potência',
      },
      xAxis: {
         title: {
            enabled: true,
            text: 'Velocidade do vento (m/s)',
         },
      },
      yAxis: {
         title: {
            text: 'Potência (kWh)',
         },
      },
   }
   
   return <HighchartsReact highcharts={Highcharts} options={{...options, series: [chartData]}} />
}

export default ScatterPlot
