import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class Deezerservice {
  constructor(private http: HttpClient) {}

  searchRelaxingMusic(): Observable<any> {
    const terms = [
      'meditation music',
      'spa relaxation', 
      'ambient calm',
      'nature sounds',
      'peaceful piano',
      'zen meditation'
    ];
    
    const randomTerm = terms[Math.floor(Math.random() * terms.length)];
    const url = `https://itunes.apple.com/search?term=${encodeURIComponent(randomTerm)}&entity=song&limit=30&media=music`;
    
    console.log('Buscando:', randomTerm);
    
    return this.http.get(url).pipe(
      map((response: any) => {
        if (!response.results || response.results.length === 0) {
          return { data: [] };
        }

        const tracks = response.results
          .filter((track: any) => track.previewUrl)
          .map((track: any) => ({
            id: track.trackId,
            title: track.trackName,
            artist: { name: track.artistName },
            preview: track.previewUrl,
            duration: track.trackTimeMillis || 30000
          }));

        console.log('Tracks encontrados:', tracks.length);
        return { data: tracks };
      })
    );
  }
}
