import { useState } from 'react'
import { ChartData } from '../../types/curve'
import { femaleSeries, maleSeries } from '../../utils/seriesMock'

const DropdownSelect = () => {
  const [items, setItems] = useState([
    { label: 'Nenhuma curva selecionada', value: 0 },
    { label: 'Curva 1', value: 1 },
    { label: 'Curva 2', value: 2 },
  ])

  return (
    <select className='form-select' aria-label='Default select example'>
      {items.map((item) => (
        <option key={item.value} value={item.value} selected={item.value === 0 ? true : false} hidden={item.value === 0 ? true : false}>
          {item.label}
        </option>
      ))}
    </select>
  )
}

export default DropdownSelect
