import { useForm } from 'react-hook-form'
import DropdownSelect from '../../components/DropdownSelect'
import ScatterPlot from '../../components/ScatterPlot'
import api from '../../services/api'

const Home = () => {
  const { register, handleSubmit } = useForm()

  const onSubmit = async (data: any) => {
    const formData = new FormData()
    formData.append('name', data.name)
    formData.append('file', data.file[0])

    await api.post('/curve', formData).then((res) => {
      // TODO Toast alert
      alert('Curva enviada com sucesso.')
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
            <DropdownSelect />
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
