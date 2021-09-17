import Highcharts from 'highcharts'
import HighchartsReact from 'highcharts-react-official'
import { femaleSeries, maleSeries } from '../../utils/seriesMock'

const options = {
   chart: {
      type: 'scatter',
      zoomType: 'xy',
   },
   series: [
      femaleSeries,
      maleSeries
   ],
}

const ScatterPlot = () => {
   return <HighchartsReact highcharts={Highcharts} options={options} />
}

export default ScatterPlot
