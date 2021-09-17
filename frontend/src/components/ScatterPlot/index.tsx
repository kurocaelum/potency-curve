import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import { femaleSeries, maleSeries } from '../../utils/seriesMock'

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
   series: [femaleSeries, maleSeries],
}

const ScatterPlot = () => {
   return <HighchartsReact highcharts={Highcharts} options={options} />
}

export default ScatterPlot
