import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import { useEffect, useState } from 'react'
import api from '../../services/api'
import { ChartData, Pair } from '../../types/curve'

type PairJson = {
   first: number,
   second: number
 }

const ScatterPlot = (props: any) => {
   // TODO renderizando 2x
   console.log('Render...')
   const [chartData, setChartData] = useState<ChartData>({ data: [] })

   useEffect(() => {
      api.get(`/curve/${props.id}`).then(response => {
         const data = response.data as PairJson[]
         
         const list: Pair[] = []
         data.forEach(x => list.push([x.first, x.second]))
         
         setChartData({ data: list })
      })
   }, [props.id])
   
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
