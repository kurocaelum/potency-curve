import React, { useEffect, useState } from 'react'
import api from '../../services/api'
import { Curve } from '../../types/curve'

const DropdownSelect = (props: any) => {
  const [items, setItems] = useState<Curve[]>([])

  useEffect(() => {
    api.get('/curve').then(res => {
      const data = res.data as Curve[]
      setItems(data)
    })
  }, [])

  useEffect(() => {

  }, [])

  return (
    <select className='form-select' aria-label='Default select example' defaultValue='0' onChange={e => props.changeId(parseInt(e.target.value))}>
      <option key='0' value='0' disabled>Selecione uma curva</option>
      {items.map((item) => (
        <option key={item.id} value={item.id}>
          {item.name}
        </option>
      ))}
    </select>
  )
}

export default React.memo(DropdownSelect)
