import ScatterPlot from '../../components/ScatterPlot'

const Home = () => {
   return (
      <>
         <div className='container'>
            <h1 className='my-4'>Curvas de Potência</h1>

            <form>
               <div className='row'>
                  <div className='col-md-5'>
                     <input type='text' className='form-control' placeholder='Informe o nome da curva de potência' />
                  </div>
                  {/* TODO input file */}
                  <div className='col-md-5'>
                     <input type='text' className='form-control' placeholder='Informe o arquivo para upload' />
                  </div>
                  <div className='col-md-2'>
                     <button className='btn btn-success'>Enviar</button>
                  </div>
               </div>
            </form>

            <div className="row my-4">
               <div className="col-md-10">
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
