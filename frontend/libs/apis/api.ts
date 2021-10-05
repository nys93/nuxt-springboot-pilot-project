import axios, { AxiosResponse } from 'axios'
import { IUser } from '~/models/user'

export const getUsers = async (): Promise<IUser[]> => {
  const axiosResponse: AxiosResponse = await axios.get(
    'http://localhost:8000/api/v1/users'
  )
  return axiosResponse.data
}
