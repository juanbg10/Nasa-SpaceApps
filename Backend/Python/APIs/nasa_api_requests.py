import requests
import json

class RequestNASA(object):
    nome_api = ''
    url_root = ''
    api_key = 'iQTboPnul6XA61N9g5sRL7czpygRdVRfNy0ehr7P'

    def __init__(self, query):
        self.query = query
        self.url_api = self.url_root +  query + '?api_key=' + self.api_key
        self.header_para_api = 'Content-Type:application/json'
        self.getresponse = self.fazer_req()

    def fazer_req(self):
        try:
            envio = requests.get(self.url_api)
            print(self.url_api)
        except requests.exceptions.Timeout:
            print('[ERRO] Tempo de conexão excedido. Tente novamente.')
        except requests.exceptions.TooManyRedirects:
            print('[ERRO] Número de redirecionamentos excedido.')
        except requests.exceptions.HTTPError:
            print('[ERRO] Resposta HTTP inválida.')
        except requests.exceptions.ConnectionError:
            print('[ERRO] Erro de conexão.')
            raise
        except requests.exceptions.RequestException:
            print('[ERRO] Não foi possível fazer request!')
        else:
            print(f'API NAME: {self.nome_api}. STATUS CODE: {envio.status_code}')
            return envio.text

    def criar_json(self):
        try:
            with open('resposta_' + self.nome_api + '.txt', 'w') as json_file:
                resposta = self.getresponse
                json.dump(resposta, json_file, indent=2)
        except:
            raise
        else:
            json_file.close()


class EpicApi(RequestNASA):
    nome_api = 'EPIC'
    url_root = 'https://api.nasa.gov/EPIC/api/'


class ImgVideoApi(RequestNASA):
    nome_api = 'ImageandVideo'
    url_root = 'https://images-api.nasa.gov/'
    endpoints = ['search',
                 'asset/',
                 'metadata/',
                 'captions/',
                 'album/']

    error_code = [(200, 'OK'),
                  (400, 'Bad request'),
                  (404, 'Not Found',
                   (500, 'Server error'))]

    '''
     API Endpoints parameters:
        q = '', # (Optional)String, Free text search terms to compare to all indexed metadata.
        center = '', #(Optional)string NASA center which published the media.
        description = '', #(Optional)string Terms to search for in “Description” fields.
        description_508 = '', #(Optional)string Terms to search for in “508 Description” fields.
        keywords = '', # (Optional) String Terms to search for in “Keywords” fields. Separate multiple values with commas.
        location = '', # (Optional) string Terms to search for in “Location” fields.
        media_type = '', # (Optional) string Media types to restrict the search to. Available types: [“image”, “audio”]. Separate multiple values with commas.
        nasa_id = '', #(optional) string The media asset’s NASA ID.
        page = '', #(Optional) integer Page number, starting at 1, of results to getresponse.
        photographer = '', # string The primary photographer’s name.
        secondary_creator = '', #string A secondary photographer/videographer’s name.
        title = '', # (Optional) string Terms to search for in “Title” fields.
        year_start = '', # (optional) string The start year for results. Format: YYYY.
        year_end = '' # (optional) string The end year for results. Format: YYYY
    '''

    #Parameters variables:
    q = 'q',
    center = 'center',
    description = 'description',
    description_508 = 'description_508',
    keywords = 'keywords',
    location = 'location',
    media_type = 'media_type',
    nasa_id = 'nasa_id',
    page = 'page',
    photographer = 'photographer',
    secondary_creator = 'secondary_creator',
    title = 'title',
    year_start = 'year_start',
    year_end = 'year_end'

    parameters = [q, center, description, description_508, keywords, location, media_type, nasa_id, page,
                    photographer, secondary_creator, title, year_start, year_end
                ]

    def fazer_req(self):
        self.url_api = self.url_root + self.endpoints[0] + '?' + self.parameters[0][0] + '=' + self.query 
        return super().fazer_req()

class EonetApi(RequestNASA):
    nome_api = 'EONETApi'
    url_root = 'https://eonet.sci.gsfc.nasa.gov/api/v2.1/'

    '''
    Events
    Categories
    Layers
    
    '''
    # Event request parameters:
    event_source = 'source'
    event_status = 'status'
    event_limit = 'limit'
    event_days = 'days'
    event_endpoint = 'events'

    event_parameters = [
        event_source, event_status, event_limit, event_days
    ]

    #Categories request parameters:
    categories_source = 'source'
    categories_status = 'status'
    categories_limit = 'limit'
    categories_days = 'days'
    categories_endpoint = 'categories'

    categories_parameters = [
        categories_source, categories_status, categories_limit, categories_days
    ]

    # Layers
    layers_categoryid = 'categoryid'
    layers_endpoint = 'layers'

    layers_parameters = [
        layers_categoryid
    ] 

    endpoints = [
        event_endpoint,
        categories_endpoint,
        layers_endpoint
    ]

    def fazer_req(self):
        # Exemplo: Exemple: https://eonet.sci.gsfc.nasa.gov/api/v2.1/events?limit=5&days=20&source=InciWeb&status=open
        self.url_api = self.url_root + self.endpoints[0] + '?' + self.parameters[0][0] + '=' + self.query
        return super().fazer_req()


ImgVideo = ImgVideoApi('apollo')
ImgVideo.criar_json()



