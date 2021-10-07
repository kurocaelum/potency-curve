import { useForm } from 'react-hook-form'
import ScatterPlot from '../../components/ScatterPlot'
import api from '../../services/api'

const Home = () => {
  const { register, handleSubmit } = useForm()

  const onSubmit = async (data: any) => {
    const formData = new FormData()
    formData.append('name', data.name)
    formData.append('file', data.file[0])

    await api.post('/curve', formData).then((res) => {
      console.log(res.data)
      alert('File uploaded successfully.')
    })
  }

  return (
    <>
      <div className='container'>
        <h1 className='my-4'>Curvas de Potência</h1>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className='row'>
            <div className='col-md-5'>
              <input {...register('name')} type='text' className='form-control' placeholder='Informe o nome da curva de potência' required />
            </div>
            <div className='col-md-5'>
              <input {...register('file')} type='file' className='form-control' accept='.csv' placeholder='Informe o arquivo para upload' required />
            </div>
            <div className='col-md-2'>
              <button type='submit' className='btn btn-success'>
                Enviar
              </button>
            </div>
          </div>
        </form>

        <div className='row my-4'>
          <div className='col-md-10'>
            <select className='form-select' aria-label='Default select example'>
              <option value='1'>Curva de potência 1</option>
              <option value='2'>Curva de potência 2</option>
              <option value='3'>Curva de potência 3</option>
            </select>
          </div>
        </div>

        <div className='mt-5'>
          <ScatterPlot />
        </div>
      </div>
    </>
  )
}

export default Home
