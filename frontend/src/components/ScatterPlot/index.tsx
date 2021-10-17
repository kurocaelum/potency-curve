import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import { useState } from 'react'
import { ChartData } from '../../types/curve'
import { femaleSeries, maleSeries } from '../../utils/seriesMock'

const ScatterPlot = () => {
   const [chartData, setChartData] = useState<ChartData>({ data: [] })
   
   // TODO option.series devem ser recebidos via props
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
   
   return <HighchartsReact highcharts={Highcharts} options={{...options, series: [femaleSeries]}} />
}

export default ScatterPlot
