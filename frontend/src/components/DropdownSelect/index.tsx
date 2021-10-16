import { useEffect, useState } from 'react'
import api from '../../services/api'
import { Curve } from '../../types/curve'

const DropdownSelect = () => {
  const [items, setItems] = useState<Curve[]>([])

  useEffect(() => {
    api.get('/curve').then(res => {
      const data = res.data as Curve[]
      setItems(data)
    })
  }, [])

  return (
    <select className='form-select' aria-label='Default select example' defaultValue='0'>
      <option key='0' value='0' disabled>Selecione uma curva</option>
      {items.map((item) => (
        <option key={item.id} value={item.id}>
          {item.name}
        </option>
      ))}
    </select>
  )
}

export default DropdownSelect
