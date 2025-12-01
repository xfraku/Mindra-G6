import { Component, OnInit } from '@angular/core';
import { Deezerservice } from '../../services/deezerservice';
import { CommonModule } from '@angular/common';
import { Observable, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-deezer',
  imports: [CommonModule],
  templateUrl: './deezer.html',
  styleUrl: './deezer.css',
})
export class Deezer implements OnInit{
  isPlaying: boolean = false;
  currentTrack: any = null;
  playlist: any[] = [];
  currentIndex: number = 0;
  audio: HTMLAudioElement | null = null;
  loading: boolean = false;
  volume: number = 0.5;
  error: string = '';

  constructor(private deezerService: Deezerservice) {}

  ngOnInit(): void {
    this.audio = new Audio();
    this.audio.volume = this.volume;
    this.audio.addEventListener('ended', () => this.playNext());
  }

  ngOnDestroy(): void {
    if (this.audio) {
      this.audio.pause();
      this.audio = null;
    }
  }

  playRelaxingMusic(): void {
    if (this.loading) return;
    
    this.loading = true;
    this.error = '';
    console.log('Iniciando búsqueda...');
    
    this.deezerService.searchRelaxingMusic().subscribe({
      next: (data) => {
        console.log('Datos recibidos:', data);
        
        if (data && data.data && data.data.length > 0) {
          this.playlist = data.data;
          this.currentIndex = 0;
          this.playTrack(this.playlist[0]);
        } else {
          this.error = 'No se encontró música';
        }
        this.loading = false;
      },
      error: (err) => {
        console.error('Error:', err);
        this.error = 'Error al cargar música';
        this.loading = false;
      }
    });
  }

  playTrack(track: any): void {
    if (!track || !track.preview) {
      this.playNext();
      return;
    }

    this.currentTrack = track;
    
    if (this.audio) {
      this.audio.src = track.preview;
      this.audio.play()
        .then(() => {
          this.isPlaying = true;
          console.log('Reproduciendo:', track.title);
        })
        .catch(err => {
          console.error('Error reproduciendo:', err);
          this.playNext();
        });
    }
  }

  togglePlay(): void {
    if (!this.audio || !this.currentTrack) return;

    if (this.isPlaying) {
      this.audio.pause();
      this.isPlaying = false;
    } else {
      this.audio.play()
        .then(() => this.isPlaying = true)
        .catch(err => console.error('Error:', err));
    }
  }

  playNext(): void {
    if (this.playlist.length === 0) return;
    
    this.currentIndex = (this.currentIndex + 1) % this.playlist.length;
    this.playTrack(this.playlist[this.currentIndex]);
  }

  stopMusic(): void {
    if (this.audio) {
      this.audio.pause();
      this.audio.currentTime = 0;
      this.isPlaying = false;
      this.currentTrack = null;
      this.playlist = [];
    }
  }
}
